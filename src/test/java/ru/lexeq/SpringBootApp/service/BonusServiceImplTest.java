package ru.lexeq.SpringBootApp.service;

import org.junit.jupiter.api.Test;
import ru.lexeq.SpringBootApp.model.Positions;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BonusServiceImplTest {

    @Test
    void calculate() {

        //given
        Positions position = Positions.HR;
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
         double result = new BonusServiceImpl().calculate(position, salary, bonus, workDays);

         //then
        double expected = 360493.8271604938;
        assertThat(result).isEqualTo(expected);
    }


    @Test
    void calculateQuarterBonusForManager() {
        //given
        Positions managerPosition = Positions.TL; // Управленческая позиция
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when
        double result = new BonusServiceImpl().calculateQuarterBonus(managerPosition, salary, bonus, workDays);

        //then
        double annualBonus = new BonusServiceImpl().calculate(managerPosition, salary, bonus, workDays);
        double expected = annualBonus / 4;
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void calculateQuarterBonusForNonManager() {
        //given
        Positions nonManagerPosition = Positions.DEV; // Не управленческая позиция
        double bonus = 2.0;
        int workDays = 243;
        double salary = 100000.00;

        //when & then
        assertThatThrownBy(() -> new BonusServiceImpl().calculateQuarterBonus(nonManagerPosition, salary, bonus, workDays))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Квартальная премия расчитывается только для руководителей")
                .hasMessageContaining("DEV");
    }

}