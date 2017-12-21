package cn.com.controller.system.file;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.model.FastDFSFile;
import cn.com.model.ResultFiles;
import cn.com.util.ConstantsUtil;
import cn.com.util.FileManager;

@Controller
@RequestMapping("/file")
public class FileController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/uploads.html")
	public @ResponseBody ResultFiles multiUploadIndex(@RequestParam(value = "file", required = false) MultipartFile[] fileToUpload,
			HttpServletRequest request, HttpServletResponse response, String name, Model model) {
		List<ResultFiles.Obj> list = new ArrayList<ResultFiles.Obj>();
		ResultFiles ajaxJson = new ResultFiles(false, ConstantsUtil.HTTPRESPONSE_STATE_ERROR);
		response.setContentType("text/plain; charset=UTF-8");
		String originalFilename = "";
		logger.info("文件上传开始……");
		try {
			for (MultipartFile myfile : fileToUpload) {
				if (myfile.isEmpty()) {
					return ajaxJson;
				} else {
					originalFilename = myfile.getOriginalFilename();
					logger.debug(originalFilename+"开始……");

					// 获取文件后缀名 
				    String ext = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
				    FastDFSFile file = new FastDFSFile(myfile.getBytes(),ext);
				    // 该段配置会在文件服务器相应目录生成元数据文件      -m
//				    NameValuePair[] meta_list = new NameValuePair[4];
//				    meta_list[0] = new NameValuePair("fileName", myfile.getOriginalFilename());
//				    meta_list[1] = new NameValuePair("fileLength", String.valueOf(myfile.getSize()));
//				    meta_list[2] = new NameValuePair("fileExt", ext);
//				    meta_list[3] = new NameValuePair("fileAuthor", FILE_AUTHOR);
//				    String filePath = FileManager.upload(file,meta_list);
				    String filePath = FileManager.upload(file,null);
				    ResultFiles.Obj obj = new ResultFiles(). new Obj();
				    obj.setUrl(filePath);
				    obj.setName(originalFilename);
				    list.add(obj);
				}
			}
			ajaxJson = new ResultFiles(true, list, ConstantsUtil.HTTPRESPONSE_STATE_TRUE);
		} catch (Exception e) {
			logger.info("文件[" + originalFilename + "]上传失败,堆栈轨迹如下");
			ajaxJson.setMsg(e.getMessage());
			e.printStackTrace();
		}
		return ajaxJson;
	}

}
