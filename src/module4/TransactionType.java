package module4;

/**
 * Created by g.zubenko on 16.11.2016.
 */
public enum TransactionType {
    WITHDRAWAL(" withdraw ", " from "),
    FUNDING(" fund ", " to "),
    TRANSFERING(" transfer ", " from "),
    PAYMENT(" pay ", " to ");

    private String comment;
    private String preposition;

    TransactionType(String comment,String preposition)
    {
        this.comment = comment;
        this.preposition = preposition;
    }

    public String getComment() {
        return comment;
    }

    public String getPreposition() {
        return preposition;
    }

}
