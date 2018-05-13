package ua.training.model.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Objects;

public class Report implements Entity<Long> {
    private Long id;
    private BigInteger moneyPutInCashMachine;
    private BigInteger seizedMoney;
    private BigInteger cashPayments;
    private BigInteger cashlessPayments;
    private BigInteger canceledCashPayments;
    private BigInteger canceledCashlessPayments;
    private int canceledChecksCount = 0;
    private int checksCount = 0;
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

    public BigInteger getCanceledCashPayments() {
        return canceledCashPayments;
    }

    public void setCanceledCashPayments(BigInteger canceledCashPayments) {
        this.canceledCashPayments = canceledCashPayments;
    }

    public BigInteger getCanceledCashlessPayments() {
        return canceledCashlessPayments;
    }

    public void setCanceledCashlessPayments(BigInteger canceledCashlessPayments) {
        this.canceledCashlessPayments = canceledCashlessPayments;
    }

    public int getChecksCount() {
        return checksCount;
    }

    public void setChecksCount(int checksCount) {
        this.checksCount = checksCount;
    }

    public static final class ReportBuilder {
        private Long id;
        private BigInteger moneyPutInCashMachine;
        private BigInteger seizedMoney;
        private BigInteger cashPayments;
        private BigInteger cashlessPayments;
        private BigInteger canceledCashPayments;
        private BigInteger canceledCashlessPayments;
        private int checksCount = 0;
        private int canceledChecksCount = 0;
        private LocalDateTime dateTime;

        public ReportBuilder setId(Long id) {
            this.id = id;
            return this;
        }

        public ReportBuilder setChecksCount(int checksCount) {
            this.checksCount = checksCount;
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

        public ReportBuilder setCanceledCashPayments(BigInteger canceledCashPayments) {
            this.canceledCashPayments = canceledCashPayments;
            return this;
        }

        public ReportBuilder setCanceledCashlessPayments(BigInteger canceledCashlessPayments) {
            this.canceledCashlessPayments = canceledCashlessPayments;
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
            report.setCanceledCashPayments(canceledCashPayments);
            report.setCanceledCashlessPayments(canceledCashlessPayments);
            report.setCanceledChecksCount(canceledChecksCount);
            report.setChecksCount(checksCount);
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
                ", canceledCashPayments=" + canceledCashPayments +
                ", canceledCashlessPayments=" + canceledCashlessPayments +
                ", checksCount=" + checksCount +
                ", canceledChecksCount=" + canceledChecksCount +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Report)) return false;
        Report report = (Report) o;
        return Objects.equals(getMoneyPutInCashMachine(), report.getMoneyPutInCashMachine()) &&
                Objects.equals(getSeizedMoney(), report.getSeizedMoney()) &&
                Objects.equals(getDateTime(), report.getDateTime());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getMoneyPutInCashMachine(), getSeizedMoney(), getDateTime());
    }
}
