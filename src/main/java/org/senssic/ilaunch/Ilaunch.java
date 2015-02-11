package org.senssic.ilaunch;

import org.senssic.bean.login.MyContent;
import org.senssic.bean.login.SelfContent;
import org.senssic.bean.order.Orders;
import org.senssic.bean.remticket.TicketInfo;
import org.senssic.bean.trainway.TrainInfo;

/**
 * 
 * 2015年2月4日 上午10:55:15
 * 
 * @version 1.0.0
 */
public interface Ilaunch {
	/**
	 * 
	 * querySeatsLeftAsBean(查询余票返回实体)
	 * 
	 * @param purpose 乘客类型(成人,学生)
	 * @param date  出发日期
	 * @param start 开始站
	 * @param end   结束站
	 * @return TicketInfo
	 * @exception
	 * @since 1.0.0
	 */
	public TicketInfo querySeatsLeftAsBean(String purpose, String date,
			String start, String end);

	/**
	 * querySeatsLeftAsString(查询余票返回实体的toString)
	 * 
     * @param purpose 乘客类型(成人,学生)
	 * @param date  出发日期
	 * @param start 开始站
	 * @param end   结束站
	 * @return TicketInfo
	 * @exception
	 * @since 1.0.0
	 */
	public String querySeatsLeftAsString(String purpose, String date,
			String start, String end);

	/**
	 * queryTrainInfoAsBean(查询车次信息返回车次实体)
	 * @param train_no  车次
	 * @param start     开始站
	 * @param end       结束站
	 * @return 
	 *TrainInfo
	 * @exception 
	 * @since  1.0.0
	 */
	public TrainInfo queryTrainInfoAsBean(String train_no, String start,
			String end);

	/**
	 * queryTrainInfoAsString(查询车次信息返回车次实体toString)
	 * 
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public String queryTrainInfoAsString(String train_no, String start,
			String end);

	/**
	 * querySelfCountAsBean(查询个人信息返回个人信息实体)
	 * 
	 * @return SelfContent
	 * @exception
	 * @since 1.0.0
	 */
	public SelfContent querySelfCountAsBean();

	/**
	 * querySelfCountAsString(查询个人信息返回实体toString)
	 * 
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public String querySelfCountAsString();

	/**
	 * queryMyContentAsBean(查询联系人返回实体bean)
	 * 
	 * @return MyContent
	 * @exception
	 * @since 1.0.0
	 */
	public MyContent queryMyContentAsBean();

	/**
	 * queryMyContentAsString(查询联系人返回实体toString)
	 * 
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public String queryMyContentAsString();
	
	/**
	 * queryOrdersAsBean(查询订单返回订单实体)
     * @param startdate 历史订单起始时间
     * @param enddate   历史订单结束时间
     * @param queryinfo [订单号,车次,乘客姓名]
     * @return 
     * @exception 
     * @since  1.0.0
	 */
	public Orders queryOrdersAsBean(String startdate, String enddate,
			String queryinfo);

	/**
	 * queryOrdersAsString(查询订单返回实体toString)
     * @param startdate 历史订单起始时间
     * @param enddate   历史订单结束时间
     * @param queryinfo [订单号,车次,乘客姓名]
     * @return 
     * @exception 
     * @since  1.0.0
	 */
	public String queryOrdersAsString(String startdate, String enddate,
			String queryinfo);
}
