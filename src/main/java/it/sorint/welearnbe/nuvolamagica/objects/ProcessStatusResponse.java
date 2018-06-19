package it.sorint.welearnbe.nuvolamagica.objects;

public class ProcessStatusResponse {
	private int exitCode;
	private String status;
	
	public int getExitCode() {
		return exitCode;
	}
	public void setExitCode(int exitCode) {
		this.exitCode = exitCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
