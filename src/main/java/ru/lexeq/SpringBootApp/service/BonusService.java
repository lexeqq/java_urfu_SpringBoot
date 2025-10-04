package ru.lexeq.SpringBootApp.service;

import org.springframework.stereotype.Service;
import ru.lexeq.SpringBootApp.model.Positions;

@Service
public interface BonusService {

    double calculate(
            Positions positions,
            double salary,
            double bonus,
            int workDays
    );

    double calculateQuarterBonus(
            Positions positions,
            double salary,
            double bonus,
            int workDays
    );

}
