public int SSF(int rows, int cols, String[] strs) {
	int curRow=0, rowSpace=cols;
	int res=0;
	int n=strs.length;
	while(curRow<rows) {
		int i=0;
		while(i<n) {
            int len=strs[i].length();
            if(len<=rowSpace) {
                rowSpace -= len+1;
                // System.out.print(strs[i]+" ");
                i++;
            }
            else {
                curRow++;
                rowSpace=cols;
                // System.out.println();
            }
            if(curRow>=rows)
                break;
        }
        if(i==n)
            res++;
    }
    return res;
}
