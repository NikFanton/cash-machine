package ua.training.model.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;

public class Report implements Entity<Long> {
    private Long id;
    private BigInteger moneyPutInCashMachine;
    private BigInteger seizedMoney;
    private BigInteger cashPayments;
    private BigInteger cashlessPayments;
    private BigInteger canceledPayments;
    private int canceledChecksCount = 0;
    private LocalDateTime dateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigInteger getMoneyPutInCashMachine() {
        return moneyPutInCashMachine;
    }

    public void setMoneyPutInCashMachine(BigInteger moneyPutInCashMachine) {
        this.moneyPutInCashMachine = moneyPutInCashMachine;
    }

    public BigInteger getSeizedMoney() {
        return seizedMoney;
    }

    public void setSeizedMoney(BigInteger seizedMoney) {
        this.seizedMoney = seizedMoney;
    }

    public BigInteger getCashPayments() {
        return cashPayments;
    }

    public void setCashPayments(BigInteger cashPayments) {
        this.cashPayments = cashPayments;
    }

    public BigInteger getCashlessPayments() {
        return cashlessPayments;
    }

    public void setCashlessPayments(BigInteger cashlessPayments) {
        this.cashlessPayments = cashlessPayments;
    }

    public BigInteger getCanceledPayments() {
        return canceledPayments;
    }

    public void setCanceledPayments(BigInteger canceledPayments) {
        this.canceledPayments = canceledPayments;
    }

    public int getCanceledChecksCount() {
        return canceledChecksCount;
    }

    public void setCanceledChecksCount(int canceledChecksCount) {
        this.canceledChecksCount = canceledChecksCount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public static ReportBuilder getBuilder() {
        return new ReportBuilder();
    }

    public static final class ReportBuilder {
        private Long id;
        private BigInteger moneyPutInCashMachine;
        private BigInteger seizedMoney;
        private BigInteger cashPayments;
        private BigInteger cashlessPayments;
        private BigInteger canceledPayments;
        private int canceledChecksCount = 0;
        private LocalDateTime dateTime;

        public ReportBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ReportBuilder setMoneyPutInCashMachine(BigInteger moneyPutInCashMachine) {
            this.moneyPutInCashMachine = moneyPutInCashMachine;
            return this;
        }

        public ReportBuilder setSeizedMoney(BigInteger seizedMoney) {
            this.seizedMoney = seizedMoney;
            return this;
        }

        public ReportBuilder setCashPayments(BigInteger cashPayments) {
            this.cashPayments = cashPayments;
            return this;
        }

        public ReportBuilder setCashlessPayments(BigInteger cashlessPayments) {
            this.cashlessPayments = cashlessPayments;
            return this;
        }

        public ReportBuilder setCanceledPayments(BigInteger canceledPayments) {
            this.canceledPayments = canceledPayments;
            return this;
        }

        public ReportBuilder setCanceledChecksCount(int canceledChecksCount) {
            this.canceledChecksCount = canceledChecksCount;
            return this;
        }

        public ReportBuilder setDateTime(LocalDateTime dateTime) {
            this.dateTime = dateTime;
            return this;
        }

        public Report build() {
            Report report = new Report();
            report.setId(id);
            report.setMoneyPutInCashMachine(moneyPutInCashMachine);
            report.setSeizedMoney(seizedMoney);
            report.setCashPayments(cashPayments);
            report.setCashlessPayments(cashlessPayments);
            report.setCanceledPayments(canceledPayments);
            report.setCanceledChecksCount(canceledChecksCount);
            report.setDateTime(dateTime);
            return report;
        }
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", moneyPutInCashMachine=" + moneyPutInCashMachine +
                ", seizedMoney=" + seizedMoney +
                ", cashPayments=" + cashPayments +
                ", cashlessPayments=" + cashlessPayments +
                ", canceledPayments=" + canceledPayments +
                ", canceledChecksCount=" + canceledChecksCount +
                ", dateTime=" + dateTime +
                '}';
    }
}
