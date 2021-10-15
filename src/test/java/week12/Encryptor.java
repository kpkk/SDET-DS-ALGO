/*
package week12;

public class Encryptor {

    public void getEncryptedName(String name){
        
        validate(name);

    }

    private void validate(String name) {
        StringBuilder sb=new StringBuilder(name);
        String reverse = sb.reverse().toString();
        reverse.toU
    }

    public List<Integer> formTeam(int d, int t, List<Integer> q) {
        int max = 0;

        for(Integer n : q)
            max = Math.max(max, n);

        List<Integer> result = new ArrayList(q.size());
        long dp[] = new long[max + 1];

        int mod = 1000000007;

        LinkedList<Long> D = new LinkedList();
        LinkedList<Long> T = new LinkedList();

        D.addFirst(1l);
        T.addFirst(1l);

        long tsum = 1, dsum = 1;

        dp[1] = 2;

        for(int i = 2; i <= max; i++){
            D.addFirst(tsum);
            T.addFirst(dsum);

            long pred = dsum;
            long pret = tsum;

            dsum += pret;
            dsum %= mod;

            tsum += pred;
            tsum %= mod;

            if(D.size() > d - 1){
                long last = D.removeLast();
                dsum -= last;

                if(dsum < 0)
                    dsum += mod;
            }

            if(T.size() > t - 1){
                long last = T.removeLast();
                tsum -= last;

                if(tsum < 0)
                    tsum += mod;
            }

            dsum %= mod;
            tsum %= mod;

            dp[i] = (dsum + tsum) % mod;

        }

        for(int i = 0; i < q.size(); i++){
            int n = q.get(i);
            result.add((int) (dp[n]));
        }

        return result;
    }
}
*/
