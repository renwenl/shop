package com.fh.shop.backend.controller.client;

import com.fh.shop.backend.biz.client.IClientService;
import com.fh.shop.backend.po.client.ClientPO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@Controller
@RequestMapping("/response/client")
public class ResponseController {

    @Resource(name="clientService")
    private IClientService clientService;

    @RequestMapping("updateDetailInfo")
    public ModelAndView updateDetailInfo(Integer id) {
        ModelAndView modelAndView = new ModelAndView("/client/update");
        ClientPO client = clientService.findClientById(id);
        modelAndView.addObject("clientInfo",client);
        return modelAndView;
    }
}
