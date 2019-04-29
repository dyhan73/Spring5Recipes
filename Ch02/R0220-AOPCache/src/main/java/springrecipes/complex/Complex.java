package springrecipes.complex;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configurable
@Component
@Scope("prototype")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Complex {
    private int real;
    private int imaginary;

    public Complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

//    @Setter
    private ComplexFormatter formatter;

    @Autowired
    public void setFormatter(ComplexFormatter complexFormatter) {
        this.formatter = complexFormatter;
    }

    @Override
    public String toString() {
        return formatter.format(this);
    }
}
