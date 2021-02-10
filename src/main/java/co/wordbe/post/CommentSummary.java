package co.wordbe.post;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommentSummary {

    public String comment;

    public int up;

    public int down;

    public String getVotes() {
        return this.up + " " + this.down;
    }
}
