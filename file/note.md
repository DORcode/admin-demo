1.父类限制后，定义castThis方法，子类可调用
<T extends AbstractSerializableParameter<T>>

@JsonIgnore
private T castThis() {
    @SuppressWarnings("unchecked")
    final T result = (T) this;
    return result;
}