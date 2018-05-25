package it.sorint.welearnbe.nuvolamagica.objects;

public class BuildRequest {
	private String chrootDir;
	private String lang;
	private String options;
	private String mainFile;
	
	
	public String getChrootDir() {
		return chrootDir;
	}
	public void setChrootDir(String chrootDir) {
		this.chrootDir = chrootDir;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getOptions() {
		return options;
	}
	public void setOptions(String options) {
		this.options = options;
	}
	public String getMainFile() {
		return mainFile;
	}
	public void setMainFile(String mainFile) {
		this.mainFile = mainFile;
	}
}
