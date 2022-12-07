package com.sopoom.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sopoom.dto.ProductVO;
import com.sopoom.service.AdminProductService;

@Controller
public class AdminProductController {

	@Autowired
	AdminProductService service; //의존성 주입
	
	Logger log = LoggerFactory.getLogger(AdminProductController.class);
	
	//게시물 등록 화면 보기
	@GetMapping("/admin/Product/productReg")
	public void GetProductReg() { }
	
	//상품 등록
	@PostMapping("/admin/Product/productReg")
	public String PostProductReg(ProductVO board, MultipartHttpServletRequest request) throws Exception{
		
		String path = "D:\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\sopoom\\resources\\upload\\";
		File dir;
		
		Iterator<String> iterator = request.getFileNames(); //업로드된 파일정보 수집
        
        String uploadFileName;
        String orgFileName = ""; //진짜 파일명
        ArrayList<String> list = new ArrayList<String>();
        MultipartFile mFile = null;
        
        while(iterator.hasNext()) {
            
            uploadFileName = iterator.next();
            mFile = request.getFile(uploadFileName);
            
            orgFileName = mFile.getOriginalFilename();    
            System.out.println(orgFileName);
            
            if(orgFileName != null && orgFileName.length() != 0) {
                System.out.println("if문 진입");
                	
				String org_fileExtension = orgFileName.substring(orgFileName.lastIndexOf("."));	
				String stored_filename =  UUID.randomUUID().toString().replaceAll("-", "") + org_fileExtension;	
 
				board.setP_fileName(stored_filename);
				
                dir = new File(path + stored_filename); 
                try {
                    System.out.println("try 진입");
                    mFile.transferTo(dir); // C:/Upload/testfile/sysFileName
                    list.add("원본파일명: " + orgFileName + ", 시스템파일명: " + stored_filename);
                    
                }catch(Exception e){
                    list.add("파일 업로드 중 에러발생!!!");
                }
            }//if
        }//while
		
		
		service.productReg(board);
		
		return "redirect:/product/list";
	}
	
	//상품 이름 중복 체크
	@GetMapping("/admin/Product/pidCheck")
	public void GetpidCheck(Model model, @RequestParam("p_id") String p_id) throws Exception{
		model.addAttribute("pidCheck", service.pidCheck(p_id));
	}

}
