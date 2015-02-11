package org.senssic.util;

import java.io.File;
import java.util.Scanner;

import org.senssic.bean.trainline.Info;
import org.senssic.bean.trainline.TrainLine;
import org.senssic.bean.trainsp.StationInfo;
import org.senssic.bean.trainsp.TrainSp;

import com.alibaba.fastjson.JSON;

/**
 * 转换
 * 
 * @author qiss
 */
public class TrainConvert {
	// 车次转为车编号
	public static String getTrannumByCZ(String checi) {
		try {
			StringBuilder sBuilder = new StringBuilder();
			Scanner scanner = new Scanner(new File(ClassLoader
					.getSystemResource("trainline.json").toURI()));
			scanner.useDelimiter("\n");
			while (scanner.hasNext()) {
				sBuilder.append(scanner.next());
			}
			scanner.close();
			TrainLine tLine = JSON.parseObject(sBuilder.toString(),
					TrainLine.class);
			for (Info inf : tLine.getInfo()) {
				if (inf.getStation_train_code().contains(checi.toUpperCase())) {
					return inf.getTrain_no();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 车站转为车站代码
	public static String getStation(String ttationName) {
		try {
			Scanner scanner = new Scanner(new File(ClassLoader
					.getSystemResource("trainspname.json").toURI()));
			StringBuilder sbBuilder = new StringBuilder();
			scanner.useDelimiter("\n");
			while (scanner.hasNext()) {
				sbBuilder.append(scanner.next());
			}
			scanner.close();
			TrainSp sp = JSON.parseObject(sbBuilder.toString(), TrainSp.class);
			for (StationInfo inf : sp.getInfo()) {
				if (ttationName.equals(inf.getName())
						|| ttationName.equals(inf.getSpfull())
						|| ttationName.equals(inf.getSpjian())) {
					return inf.getStation();
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	// 车票类型
	public static String getType(String type) {
		if (type.equals("成人票") || type.equals("成人")) {
			return "0X00";
		} else if (type.equals("学生票") || type.equals("学生")) {
			return "ADULT";
		} else {
			return "ADULT";
		}
	}
}
