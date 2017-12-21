package cn.com.util;

import java.io.File;

import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.model.FastDFSFile;
import cn.com.model.FileManagerConfig;

/**
 * <strong>类概要： FastDFS Java客户端工具类</strong> <br>
 * <strong>创建时间： 2016-9-26 上午10:26:48</strong> <br>
 * @author I'amour solitaire
 *
 */
@Component
public class FileManager implements FileManagerConfig {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1596178387775637078L;
	
	private static Logger logger = LoggerFactory.getLogger(FileManager.class);
	
	private static StorageClient storageClient = null;
	
	static {
		try {
			ClientGlobal.init(FileManager.class.getClassLoader().getResource("").getPath()+File.separator+"fdfs_client.conf");
			TrackerClient trackerClient = new TrackerClient(ClientGlobal.g_tracker_group);
			TrackerServer trackerServer = trackerClient.getConnection();
			if (null == trackerServer) {
				logger.info("getConnection return null");
			}
			StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
			if (storageServer == null) {
				logger.info("getStoreStorage return null");
			}
			storageClient = new StorageClient(trackerServer, storageServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * <strong>方法概要： 文件上传</strong> <br>
     * <strong>创建时间： 2016-9-26 上午10:26:11</strong> <br>
     * 
     * @param FastDFSFile
     *            file
     * @return fileAbsolutePath
     * @author Wang Liang
     */
    public static String upload(FastDFSFile file,NameValuePair[] valuePairs) {
        String[] uploadResults = null;
        try {
            uploadResults = storageClient.upload_file(file.getContent(),file.getExt(), valuePairs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String groupName = uploadResults[0];
        String remoteFileName = uploadResults[1];

        String fileAbsolutePath = "http://192.168.43.183:8888"
                + SEPARATOR + groupName
                + SEPARATOR + remoteFileName;
        return fileAbsolutePath;
    }

}
