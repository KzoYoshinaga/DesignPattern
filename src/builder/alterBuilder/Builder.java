package builder.alterBuilder;

public abstract class Builder implements Buildable{
	// Direction の中で construct を呼ばれたらやばい
	// Direction には Buildable インターフェイスで渡す
	public void construct(Direction direction) {
		direction.constract(this);
	}
}
