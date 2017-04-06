package org.ricky.twtnewspro.bean;

/**
 * Created by Ricky on 2017/3/7.
 */

public class NewsSummaryDataBean {
    /**
     * index : 53363
     * subject : 詹津原先生做客北洋大讲堂
     * pic :
     * visitcount : 32
     * comments : 0
     * summary : 2月28日下午2时30分，珠海国际赛车场有限公司董事长、广东省汽车摩托车运动联合会副主席...
     */

    private int index;
    private String subject;
    private String pic;
    private int visitcount;
    private int comments;
    private String summary;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getVisitcount() {
        return visitcount;
    }

    public void setVisitcount(int visitcount) {
        this.visitcount = visitcount;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
