package it.sorint.welearnbe.repository.entity;

public class ExecutionConfigBE {
	private String name;
	private String lang;
	private String mainFile;
	
	
	public ExecutionConfigBE(String name, String lang, String mainFile) {
		super();
		this.name = name;
		this.lang = lang;
		this.mainFile = mainFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getMainFile() {
		return mainFile;
	}
	public void setMainFile(String mainFile) {
		this.mainFile = mainFile;
	}	
}
