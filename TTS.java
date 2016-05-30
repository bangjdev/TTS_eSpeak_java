import java.io.IOException;

public class TTS {
	String sourceFile;
	String voice;
	int speed;

	public TTS(String voice, int speed) { // Init eSpeak with voice and speed
		this.voice = voice;
		this.speed = speed;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public void say() throws IOException, InterruptedException {
		String command = "espeak -s " + getSpeed() + " -v " + getVoice() + " -f " + getSourceFile();
		Process pro = Runtime.getRuntime().exec(command);
		
	}
	public void sayAPart(int head, int ass) { // =)) LOLOLOL
		
	}
}
