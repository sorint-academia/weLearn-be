package it.sorint.welearnbe.controllers.entity;

public class FileWithContentFE extends FileFE {
	private byte[] content;

	public byte[] getContent() {
		return content;
	}
	public void setContent(byte[] content) {
		this.content = content;
	}
}
