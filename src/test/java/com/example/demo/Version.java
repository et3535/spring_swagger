package com.example.demo;

import java.util.regex.Pattern;

public class Version implements Comparable<Version>  {
    static final String afpattern = "\\d+(\\.\\d+){0,2}(-SNAPSHOT)";
    static final String bfpattern2 = "\\d+(\\.\\d+){0,2}";
    static final String errorVersionMustNotBeNull = "'version' must not be null!";
    static final String errorOtherMustNotBeNull =  "'other' must not be null!";
    static final String errorVersionMustMatchPattern =  "'version' must match: 'major.minor.patch(-SNAPSHOT)'!";
    private String version;
    @Override
    public int compareTo(Version v){
                String[] strArr1 = this.version.split("-")[0].split("\\.");
                String[] strArr2 = v.version.split("-")[0].split("\\.");
                if(strArr1[0]==strArr2[0]){
                    if(strArr1[1]==strArr2[1]){
                        if(strArr1[2]==strArr2[2]){
                            boolean bf_regex = Pattern.matches(afpattern, this.version);
                            boolean af_regex = Pattern.matches(afpattern, v.version);
                            if(bf_regex==true && af_regex==true ){
                                return 0;
                            }else if(bf_regex==false && af_regex==true){
                                return -1;   
                            }else{
                                return 1;
                            }
                        }else if(Integer.parseInt(strArr1[0])<Integer.parseInt(strArr2[2])){
                            return -1;
                        }   
                    }else if(Integer.parseInt(strArr1[1])<Integer.parseInt(strArr2[1])){
                        return -1;   
                    }   
                }else if(Integer.parseInt(strArr1[0])<Integer.parseInt(strArr2[0])){
                    return -1;
                }else{
                    return 1;
                }
				return 0;

    }
    
    public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public Version(String version){
        System.out.println("version  ");
        boolean bf_regex = Pattern.matches(afpattern, version);
        boolean af_regex = Pattern.matches(afpattern, version);
        if(!bf_regex){
            if(!af_regex){
                throw new IllegalArgumentException(errorVersionMustMatchPattern);
            }
        }
        this.version = version;
 
        System.out.println("version ");
    }
    public Version(){
        System.out.println("null");
        throw new IllegalArgumentException(errorVersionMustNotBeNull);
    }

}