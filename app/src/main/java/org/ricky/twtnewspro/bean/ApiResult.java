package org.ricky.twtnewspro.bean;

/**
 * Created by Ricky on 2017/3/7.
 */

public class ApiResult<T> {

    /**
     * error_code : -1
     * message :
     * data : [{"index":53370,"subject":"接力雷锋日，天大学子感恩行\u2014\u2014暨\u201c3·5雷锋纪念日\u201d活动","pic":"","visitcount":13,"comments":0,"summary":"暖春三月，学雷锋纪念日当天，天津市福寿宫老人院和望园敬老院迎来了一批朝气蓬勃的年..."},{"index":53369,"subject":"助力雷锋日，接力雷锋行\u2014\u2014勤工助学中心雷锋日主题志愿活动","pic":"","visitcount":10,"comments":0,"summary":"暖春三月，由天津大学勤工助学中心主办的纪念雷锋活动将在3月5日全面展开，本次活动旨..."},{"index":53363,"subject":"詹津原先生做客北洋大讲堂","pic":"","visitcount":32,"comments":0,"summary":"2月28日下午2时30分，珠海国际赛车场有限公司董事长、广东省汽车摩托车运动联合会副主席..."},{"index":53361,"subject":"\u201c阳光成长艺展北洋\u201d：天津大学阳光兴趣类社团文艺汇演圆满落幕","pic":"http://open.twtstudio.com/imgcache/6919ff6779acf05908ceca84a7c36da1.jpg","visitcount":49,"comments":0,"summary":"2016年12月28日晚6：30，\u201c阳光成长 艺展北洋\u201d\u2014 \u2014天津大学阳光兴趣类社团文艺汇演在北..."},{"index":53357,"subject":"16172学期心理咨询及治疗服务已正式启动","pic":"/post/img/uploadFiles/2017_02_26_12_54_26_245.jpg","visitcount":24,"comments":0,"summary":"新的学年再度开启，天津大学心理健康教育中心将继续为同学们提供心理咨询及治疗服务。..."},{"index":53354,"subject":"北洋园校内岗招聘会圆满结束","pic":"/post/img/uploadFiles/2017_02_26_11_33_05_6.png","visitcount":64,"comments":0,"summary":"2月24日晚，天津大学勤工助学管理办公室在北洋园校区大通学生中心c区一层举办了16172学期..."},{"index":53347,"subject":"乘风破浪 荣耀归来：记天津大学国旗护卫队第十九届队员冬训圆满结束","pic":"/post/img/uploadFiles/2017_02_19_10_18_10_27.jpg","visitcount":91,"comments":0,"summary":"2月18日下午，天津大学国旗护卫队第十九届队员在指导老师梁光强、武装部马占英老师、朱..."},{"index":53346,"subject":"五位诺奖得主做客北洋大讲堂","pic":"","visitcount":67,"comments":0,"summary":"2月23日下午，\u201c对话诺奖大师 感悟科学人生\u201d讲座于天津大学北洋园校区求实会堂顺利举..."},{"index":53337,"subject":"天津大学成功举办第四期面试特训","pic":"/post/img/uploadFiles/2017_01_10_15_41_48_128.jpg","visitcount":296,"comments":0,"summary":"为切实提高我校博士生的就业质量，提升天大学子面试能力，增强天大学子面试信心，天津..."},{"index":53336,"subject":"天津大学\u201c美丽课堂\u201d系列培训之女大学生精致妆容培训成功举办","pic":"/post/img/uploadFiles/2017_01_10_15_32_37_128.jpg","visitcount":391,"comments":0,"summary":"11月16日、17日下午，天津大学\u201c美丽课堂\u201d女大学生精致妆容培训在北洋园校区体育馆一层..."},{"index":53329,"subject":"江雷院士做客北洋大讲堂","pic":"","visitcount":393,"comments":0,"summary":"引经据典研述科学之事，博古通今娓道生活之实。1月4日下午两点整，中国科学院院士、美..."},{"index":53328,"subject":"精仪青协\u201c十年有你 苹安相伴\u201d苹果义卖活动圆满完成","pic":"/post/img/uploadFiles/2017_01_02_11_56_03_20.jpg","visitcount":436,"comments":0,"summary":"12月，由精仪青协携手理学院青协，经管学院青协举办的的苹果义卖活动成功举办。活动前..."}]
     */

    public static final int NO_ERROR = -1;

    private int error_code;
    private String message;
    private T data;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
