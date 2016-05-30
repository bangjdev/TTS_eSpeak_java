import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

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

	/*
	 * This method is used to say a part in file, from line head to ass
	 */
	public void sayAPart(int head, int ass, boolean wbw) throws IOException, InterruptedException {
		// Load file
		String line[] = new String[100000];
		int n = 0;
		FileInputStream fis = new FileInputStream(new File(getSourceFile()));
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		String l = br.readLine();
		while (l != null) {
			System.out.println(l);
			Thread.sleep(1000);
			n++;
			line[n] = l;
			l = br.readLine();
		}
		fis.close();
		br.close();

		// Say
		String temp = getSourceFile();
		setSourceFile("temporary_text_file.txt");
		PrintWriter pw = new PrintWriter(new File(getSourceFile()));
		for (int i = head; i <= min(n, ass); i++) {
			pw.println(line[i]);
		}
		pw.flush();
		pw.close();
		say();
		setSourceFile(temp);
	}

	private int min(int n, int ass) {
		if (n < ass)
			return n;
		return ass;
	}
}

