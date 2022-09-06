package _02.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import _02.model.LotteryBean;
import _02.service.LotteryService;

@Controller
public class LotteryController {

	@Autowired
	LotteryService lotteryService;

	// 查詢明牌
	@GetMapping("/_01/getLottery")
	public String queryLottery() {
		return "_01/showLotteryForm";
	}

	// 查詢明牌
	@PostMapping(value = "/_01/GenLotteryNumbers", produces = { "application/json" })
	public @ResponseBody Map<String, String> generateLottery(
			@RequestParam(value = "visitor", defaultValue = "訪客") String visitor,
			@RequestParam(value = "addr0", defaultValue = "(未輸入)") String addr0) {
		Map<String, String> map = new HashMap<>();
		lotteryService.setLowerBound(0);
		lotteryService.setUpperBound(9);
		lotteryService.setBallNumber(4);
		LotteryBean bean = lotteryService.getFourStars();
		map.put("name", visitor);
		map.put("addrAjax1", addr0);
		map.put("number", bean.toString());
		return map;
	}

}
