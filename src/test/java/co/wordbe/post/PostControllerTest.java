package co.wordbe.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    PostRepository postRepository;

//    @Test
//    public void getPost() throws Exception {
//        Post post = new Post();
//        post.setTitle("Jack");
//        postRepository.save(post);
//
//        mockMvc.perform(get("/posts/8"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string("Jack"))
//                ;
//
//        postRepository.delete(post);
//    }

    @Test
    public void getPosts() throws Exception {
        createPosts();

        mockMvc.perform(get("/posts")
                    .param("page", "2")
                    .param("size", "10")
                    .param("sort", "created,desc")
                    .param("sort", "title"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$._embedded.postList[0].title", is(equalTo("Jack"))));
        ;
    }

    private void createPosts() {
        int postsCount = 100;

        while(postsCount > 0) {
            Post post = new Post();
            post.setTitle("Jack");
            postRepository.save(post);
            postsCount--;
        }
    }
}