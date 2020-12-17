package org.cdapi.structure;

public class Tag {

    private String info;
    private String content;
    private Tag first;
    private Tag next;

    /**
     *
     * @return
     */
    public String getInfo() {
        return info;
    }

    /**
     *
     * @param info
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     *
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @return
     */
    public Tag getFirst() {
        return first;
    }

    /**
     *
     * @param first
     */
    public void setFirst(Tag first) {
        this.first = first;
    }

    /**
     *
     * @return
     */
    public Tag getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(Tag next) {
        this.next = next;
    }

}
