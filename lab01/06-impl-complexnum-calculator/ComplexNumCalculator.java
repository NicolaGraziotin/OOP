
public class ComplexNumCalculator {

    int nOpDone;
    ComplexNum lastRes;

    void build() {
        nOpDone = 0;
        this.lastRes = new ComplexNum();
    }

    ComplexNum add(ComplexNum num1, ComplexNum num2) {
        nOpDone++;
        this.lastRes.build(num1.re + num2.re, num1.im + num2.im);
        return this.lastRes;
    }

    ComplexNum sub(ComplexNum num1, ComplexNum num2) {
        nOpDone++;
        this.lastRes.build(num1.re - num2.re, num1.im - num2.im);
        return this.lastRes;
    }

    ComplexNum mul(ComplexNum num1, ComplexNum num2) {
        nOpDone++;
        this.lastRes.build(num1.re*num2.re - num1.im*num2.im, num1.im*num2.re + num1.re*num2.im);
        return this.lastRes;
    }

    ComplexNum div(ComplexNum num1, ComplexNum num2) {
        nOpDone++;
        this.lastRes.build((num1.re*num2.re + num1.im*num2.im) / (Math.pow(num2.re, 2) + Math.pow(num2.im, 2)), (num1.im*num2.re - num1.re*num2.im) / (Math.pow(num2.re, 2) + Math.pow(num2.im, 2)));
        return this.lastRes;
    }
}
