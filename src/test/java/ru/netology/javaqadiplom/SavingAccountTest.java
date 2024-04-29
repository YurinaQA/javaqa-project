package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }
    @Test
    public void shouldAddZeroThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void shouldAddNegativeThanMaxBalance1() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());

    }

    @Test
    public void minBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getMinBalance());
    }

    @Test
    public void maxBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                0,
                0,
                5
        );

        Assertions.assertEquals(0, account.getMaxBalance());
    }

    @Test //0-ой начальный балланс
    public void initialBalanceEqualZero() {
        SavingAccount account = new SavingAccount(
                0,
                1_000,
                10_000,
                5
        );

        Assertions.assertEquals(0, account.getBalance());
    }

    @Test //Проверка 0-ой проц. ставки
    public void rateEqualZero() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                0
        );

        Assertions.assertEquals(0, account.getRate());
    }

    @Test //Проверка начального отрицательного баланса
    public void initialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    -5_000,
                    1_000,
                    10_000,
                    5
            );
        });
    }

    @Test //Проверка minBalance отрицательного баланса
    public void minBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    -1_000,
                    10_000,
                    5
            );
        });
    }

    @Test //Проверка maxBalance отрицательного баланса
    public void maxBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    -10_000,
                    5
            );
        });
    }

    @Test //Проверка отрицательной ставки
    public void rateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5
            );
        });
    }

    @Test
    public void maxBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    2_000,
                    1_000,
                    100,
                    5
            );
        });

    }

    @Test
    public void initialBalanceLessMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    200,
                    1_000,
                    10_000,
                    5
            );
        });

    }

    @Test
    public void initialBalanceMoreMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new SavingAccount(
                    20_000,
                    1_000,
                    10_000,
                    5
            );
        });

    }

}
