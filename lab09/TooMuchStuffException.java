package lab09;

public class TooMuchStuffException extends Exception {// 24ÃÊ°ú½Ã
	private int inputNum;

	public TooMuchStuffException() {
		super("Too much stuff");
	}

	public TooMuchStuffException(String message) {
		super(message);
	}

	public TooMuchStuffException(int num) {
		super("Too much stuff");
		inputNum = num;
	}

	public int getInputNum() {
		return this.inputNum;
	}
}
