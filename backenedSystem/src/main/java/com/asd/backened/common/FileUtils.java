package com.asd.backened.common;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * File related operations
 * @author Xuhao Guo and Yongyan Liu
 * @date 2022
 */
public class FileUtils {

	/**
	 * Download files
	 * @param response
	 * @param file
	 * @param newFileName
	 */
	public static void downloadFile(HttpServletResponse response, File file, String newFileName) {
		try {
			response.setHeader("Content-Disposition", "attachment; filename=" + new String(newFileName.getBytes("ISO-8859-1"), "UTF-8"));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			InputStream is = new FileInputStream(file.getAbsolutePath());
			BufferedInputStream bis = new BufferedInputStream(is);
			int length = 0;
			byte[] temp = new byte[1 * 1024 * 10];
			while ((length = bis.read(temp)) != -1) {
				bos.write(temp, 0, length);
			}
			bos.flush();
			bis.close();
			bos.close();
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Read the contents of TXT file
	 * @param file The path where you want to read the file
	 * @return Return file contents
	 */
	public static String readFile(String file){
		return readFile(new File(file));
	}
	
    /**
     * Read the contents of TXT file
     * @param file Objects that want to read files
     * @return Return file contents
     */
    public static String readFile(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
            	//Read only one line at a time
                result.append(System.lineSeparator() + s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    
    /**
	 * Recursively delete files
	 * @param file
	 */
	public static void deleteFile(File file) {
	    // Is it a directory? If not, skip direct deletion. If it is a directory, clear the contents first
	    if(file.isDirectory()) {
	        // Get sub files or subdirectories
	        File[] subFiles = file.listFiles();
	        // Directory of vertical transformer
	        for (File subFile : subFiles) {
	            // Recursive call to delete the file. If this is an empty directory or file, one recursion can be completed. If this is a non empty directory, the contents can be deleted after multiple recursions
	            deleteFile(subFile);
	        }
	    }
	    // Delete empty directories or files
	    file.delete();
	}
	
	/**
	 * Get project root directory
	 * @return
	 */
	public static String getProjectPath() {
		String classPath = getClassPath();
		return new File(classPath).getParentFile().getParentFile().getAbsolutePath();
	}

	/**
	 * Get classpath
	 * @return
	 */
	public static String getClassPath() {
		String classPath = FileUtils.class.getClassLoader().getResource("").getPath();
		return classPath;
	}
	
	public static void main(String[] args){
//        File file = new File("D:/errlog.txt");
//        System.out.println(readFile(file));
        System.out.println(getClassPath());
        System.out.println(getProjectPath());
    }
}
