package com.example.grpc.client.grpcclient;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.accept.PathExtensionContentNegotiationStrategy;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.example.grpc.client.grpcclient.storage.*;

@Controller
public class FileUploadController {
    private GRPCClientService g;
    public static String uploadDirectory = System.getProperty("user.dir") + "/uploads";
    private StorageService s;
    private StorageProperties p;

    @Autowired
    public FileUploadController(StorageService s, StorageProperties p, GRPCClientService g) {
        this.s = s;
        this.p = p;
        this.g = g;
    }

    @RequestMapping("/")
    public String UploadPage(Model model) {
        return "uploadview";
    }


    /*@RequestMapping("/add")
    public String add(Model model, @RequestParam("file") MultipartFile file) {
        if (file == null) {
            noFileAdded(model);
        }
        s.store(file);
        String f = Paths.get(p.getLocation(),file.getOriginalFilename()).toString();
        int[][][] matrices = g.GrpcService(model, f);
        s.deleteAll();
        int[][] matrixA = matrices[0];
        int[][] matrixB = matrices[1];
        int[][] matrixC = g.addMatrices(matrixA, matrixB);
        model.addAttribute("matrix", matrixAsString(matrixC));
        return "addresult";
    }*/

    @RequestMapping("/multiply")
    public String multiply(Model model, @RequestParam("file") MultipartFile file, @RequestParam("deadline") int deadline) {
        if (file == null) {
            noFileAdded(model);
        }
        s.store(file);
        String f = Paths.get(p.getLocation(),file.getOriginalFilename()).toString();
        int[][][] matrices = g.GrpcService(model, f);
        s.deleteAll();
        int[][] matrixA = matrices[0];
        int[][] matrixB = matrices[1];
        int[][] matrixC = g.multiplyMatrices(matrixA, matrixB, deadline);
        model.addAttribute("matrix", matrixAsString(matrixC));
        return "addresult";
    }

    public String matrixAsString(int[][] m) {
        String line = "";
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[i].length; j++) {
                if (j == m[i].length - 1) {
                    line += m[i][j] + "<br>";
                } else {
                    line += m[i][j] + " ";
                }
            }
        }
        return line;
    }

    @RequestMapping("/err")
    public String noFileAdded(Model model) {
        model.addAttribute("msg", "No file was added to the system");
        return "errorform";
    }
    
}