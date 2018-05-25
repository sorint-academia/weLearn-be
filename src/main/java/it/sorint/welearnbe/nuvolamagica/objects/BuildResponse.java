package it.sorint.welearnbe.nuvolamagica.objects;

public class BuildResponse {
	int compilationResultCode;
	String compilationOutput;
	
	
	public int getCompilationResultCode() {
		return compilationResultCode;
	}
	public void setCompilationResultCode(int compilationResultCode) {
		this.compilationResultCode = compilationResultCode;
	}
	public String getCompilationOutput() {
		return compilationOutput;
	}
	public void setCompilationOutput(String compilationOutput) {
		this.compilationOutput = compilationOutput;
	}
}
