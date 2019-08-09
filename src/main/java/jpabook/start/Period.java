package jpabook.start;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class Period {
    @Temporal(TemporalType.DATE)
    Date startDate;

    @Temporal(TemporalType.DATE)
    Date endDate;

    public boolean isWork(Date date){   //값 타입을 위한 메소드를 정의할 수 있다.
        return true;
    }
}

