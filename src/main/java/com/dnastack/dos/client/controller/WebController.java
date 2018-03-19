package com.dnastack.dos.client.controller;

import com.dnastack.dos.client.model.DataNode;
import com.dnastack.dos.client.repository.DataNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Controller class
 *
 * @Author: marchuang <br/>
 * @since: 1.0.0 <br/>
 */
@Controller
public class WebController {

    @Autowired
    private DataNodeRepository dataNodeRepository;

    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/nodes")
    public String customers(Principal principal, Model model) {
        Iterable<DataNode> customers = dataNodeRepository.findAll();
        model.addAttribute("nodes", customers);
        model.addAttribute("username", principal.getName());
        return "nodes";
    }

}
