package springrecipes.sequence2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Primary
public class DatePrefixGenerator implements PrefixGenerator {

    private String pattern;

    public DatePrefixGenerator() {
        this.pattern = "yyyyMMdd";
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public String getPrefix() {
        DateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(new Date());
    }
}
