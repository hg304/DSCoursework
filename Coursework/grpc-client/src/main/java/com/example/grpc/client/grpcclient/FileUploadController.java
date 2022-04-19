package com.example.grpc.client.grpcclient;

import java.nio.file.Paths;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    //the page the user will first start at
    @RequestMapping("/")
    public String UploadPage(Model model) {
        return "upload";
    }


    //will perform the addition operation and then return the results to the result html page
    @RequestMapping("/add")
    public String add(Model model, @RequestParam("file") MultipartFile file, @RequestParam("deadline") String deadlineString) throws InterruptedException, ExecutionException {
        if ((file.isEmpty()) || (deadlineString.isEmpty())) {
            model.addAttribute("msg", "One of the required information is missing");
            return "errorform";
        }
        s.store(file);
        long deadline = Long.parseLong(deadlineString);
        String f = Paths.get(p.getLocation(),file.getOriginalFilename()).toString();
        int[][][] matrices = g.GrpcService(model, f);
        if (matrices[0][0][0] == 1) {
            model.addAttribute("msg", "One of the matrices was not a power of 2");
            return "errorform";
        } else if (matrices[0][0][0] == 2) {
            model.addAttribute("msg", "The two matrices are not of the same dimensions");
            return "errorform";
        } else if (matrices[0][0][0] == 3) {
            model.addAttribute("msg", "One of the matrices is not a square matrix");
            return "errorform";
        } else {
            int[][] matrixA = matrices[0];
            int[][] matrixB = matrices[1];
            int[][] matrixC = g.addMatrices(matrixA, matrixB, deadline);
            model.addAttribute("matrix", matrixAsString(matrixC));
            return "result";
        }
    }

    //will perform the multiplication operation and then return the results to the result html page
    @RequestMapping("/multiply")
    public String multiply(Model model, @RequestParam("file") MultipartFile file, @RequestParam("deadline") String deadlineString) throws InterruptedException, ExecutionException {
        if ((file.isEmpty()) || (deadlineString.isEmpty())) {
            model.addAttribute("msg", "One of the required information is missing");
            return "errorform";
        }
        s.store(file);
        long deadline = Long.parseLong(deadlineString);
        String f = Paths.get(p.getLocation(),file.getOriginalFilename()).toString();
        int[][][] matrices = g.GrpcService(model, f);
        if (matrices[0][0][0] == 1) {
            model.addAttribute("msg", "The two matrices are not of the same dimensions");
            return "errorform";
        } else if (matrices[0][0][0] == 2) {
            model.addAttribute("msg", "One of the matrices is not a power of 2");
            return "errorform";
        } else if (matrices[0][0][0] == 3) {
            model.addAttribute("msg", "One of the matrices is not a square matrix");
            return "errorform";
        } else {
            int[][] matrixA = matrices[0];
            int[][] matrixB = matrices[1];
<<<<<<< HEAD
            int[][] matrixC = g.multiplyMatrices(matrixA, matrixB, deadline);
=======
            int[][] matrixC = g.addMatrices(matrixA, matrixB, Long.parseLong(deadline));
>>>>>>> parent of e6d9095 (FINISHED)
            model.addAttribute("matrix", matrixAsString(matrixC));
            return "result";
        }
    }

    //method to convert 2D array matrix into string form for the html page
    public String matrixAsString(int[][] m) {
        String line = "";
        for (int i=0; i<m.length; i++) {
            for (int j=0; j<m[i].length; j++) {
                if (j == m[i].length - 1) {
                    line += m[i][j] + "<br/>";
                } else {
                    line += m[i][j] + " ";
                }
            }
        }
        return line;
    }
    
}