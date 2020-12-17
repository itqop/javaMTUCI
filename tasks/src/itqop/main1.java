package itqop;

public class main1 extends func {
    public static void main(String[] args) {
        // 1
        System.out.println("#1");
        int u = remainder(5,5);
        System.out.println(u);
        // 2
        System.out.println("#2");
        int x = triArea(3,2);
        System.out.println(x);
        // 3
        System.out.println("#3");
        int c = animals(1,2,3);
        System.out.println(c);
        // 4
        System.out.println("#4");
        profitableGamble(0.9 ,1,2);
        // 5
        System.out.println("#5");
        operation(24,26,2);
        //6
        System.out.println("#6");
        ctoa('m');
        //7
        System.out.println("#7");
        int n;
        n = addUpTo(3);
        System.out.println(n);
        //8
        System.out.println("#8");
        int w;
        w = nextEdge(5,7);
        System.out.println(w);
        //9
        System.out.println("#9");
        int[] q = {3, 4, 5};
        int s = sumOfCubes(q);
        System.out.println(s);
        //10
        System.out.println("#10");
        int j;
        j = abcmath(42,5,10);
        System.out.println(j);
        //2.1
        System.out.println("#2.1");
        System.out.println(repeat("mice",5));
        //2.2
        System.out.println("#2.2");
        int[] h = {10, 4, 1, 4, -10, -50, 32, 21};
        int pp = different(h);
        System.out.println(pp);
        //2.3
        System.out.println("#2.3");
        int[] hh = {1, 2, 3, 4};
        System.out.println(isAvgWhole(hh));
        //2.4
        System.out.println("#2.4");
        int[] mw = {1,2,3};
        int[] ur = cumulativeSum(mw);
        for (int i = 0; i < ur.length; i++) {
            System.out.println(ur[i]+ " ");
        }
        //2.5
        System.out.println("#2.5");
        System.out.println(getDecimalPlaces("400.33"));
        //2.6
        System.out.println("#2.6");
        System.out.println(Fibonacci(7));
        //2.7
        System.out.println("#2.7");
        System.out.println(isValid("59001"));
        //2.8
        System.out.println("#2.8");
        System.out.println(isStrangePair("", "") );
        //2.9
        System.out.println("#2.9");
        System.out.println(isPrefix("automation", "auto-"));
        System.out.println(isSuffix("arachnophobia", "-phobia"));
        //2.10
        System.out.println("#2.10");
        System.out.println(boxSeq(4));
        //3.1
        System.out.println("#3.1");
        System.out.println(solutions(1,0,0));
        //3.2
        System.out.println("#3.2");
        System.out.println(findZip("all  zip zip files zipped are "));
        //3.3
        System.out.println("#3.3");
        System.out.println(checkPerfect(97));
        //3.4
        System.out.println("#3.4");
        System.out.println(flipEndChars("Ada"));
        //3.5
        System.out.println("#3.5");
        System.out.println(isValidHexCode("#EAECEE"));
        //3.6
        System.out.println("#3.6");
        int[] f = {4, 3, 3, 1, 2};
        int[] g = {5, 3, 2, 3, 2};
        System.out.println(arrUnic(f,g));
        //3.7
        System.out.println("#3.7");
        System.out.println(isKaprekar(297));
        //3.8
        System.out.println("#3.8");
        System.out.println(longestZero("10010001"));
        //3.9
        System.out.println("#3.9");
        System.out.println(nextPrime(12));
        //3.10
        System.out.println("#3.10");
        System.out.println(rightTriangle(70, 130, 110));
        //4.1
        System.out.println("#4.1");
        System.out.println(text("10,7 hello my name is Bessie and this is my essay"));
        //4.2
        System.out.println("#4.2");
        System.out.println(split("()()()"));
        //4.3
        System.out.println("#4.3");
        System.out.println(toCamelCase("hello_edabit_dasda_daasda"));
        System.out.println(toSnakeCase("hellEdabiDasdDaasda"));
        //4.4
        System.out.println("#4.4");
        double [] t = {16, 18, 30, 1.8};
        System.out.println(overTime(t));
        //4.5
        System.out.println("#4.5");
        System.out.println(BMT("154 pounds", "2 meters"));
        //4.6
        System.out.println("#4.6");
        System.out.println(bugger(999));
        //4.7
        System.out.println("#4.7");
        System.out.println(toStarShorthand("abc") );
        //4.8
        System.out.println("#4.8");
        System.out.println(doesRhyme("Sam I am!", "Green eggs and HAM."));
        //4.9
        System.out.println("#4.9");
        System.out.println(trouble(451999277, 41177722899l));
        //4.10
        System.out.println("#4.10");
        System.out.println(countUniqueBooks("AZYWABBCATTTA", 'A'));
        //5.1
        System.out.println("#5.1");
        System.out.println(encrypt("Hello"));
        int[] xxx = {72, 33, -73, 84, -12, -3, 13, -13, -68};
        System.out.println(decrypt(xxx));
        //5.2
        System.out.println("#5.2");
        System.out.println(canMove("King", "D5", "E5"));
        //5.3
        System.out.println("#5.3");
        System.out.println(canComplete("butl", "beautiful"));
        //5.4
        System.out.println("#5.4");
        System.out.println(sumDigProd(16,28));
        //5.5
        System.out.println("#5.5");
        String[] bbc = {"hoops", "chuff", "bot", "bottom"};
        System.out.println(sameVowelGroup(bbc));
        //5.6
        System.out.println("#5.6");
        System.out.println(validateCard(1234567890123452l));
        //5.7
        System.out.println("#5.7");
        System.out.println(numToEng(10));
        System.out.println(numToRus(999));
        //5.8
        System.out.println("#5.8");
        //5.9
        System.out.println("#5.9");
        System.out.println(correctTitle("jOn SnoW, kINg IN thE noRth."));
        //5.10
        System.out.println("#5.10");
        System.out.println(hexLattice(919));
    }
}
