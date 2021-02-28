
public class Perceptron {

		public static void main(String [] args) {
			float[] input = {75,30,40,25,15,95,88,16}; //{(float) -0.3,3,(float) -1.5, 5};
			float[] output = {+1,+1,+1,-1,-1,+1,+1,-1}; //{+1,-1,+1,-1};
			float[] weight = {0,0};
			int j=0,z=0;
			do {
				float sum=0;
				float h = 0;
				for(int i=0;i<input.length;i++) {
					float[] X1= {1,input[i]};					
					for(j=0;j<weight.length;j++) {
						h= X1[j]*weight[j];
						sum += h;
					}
					if ( sign(sum) != sign(output[i])) {
						weight=tweek(weight,output[i],X1);
					}
				}	
				z++;
			}while(z<=100);
			for(int l=0;l<weight.length;l++) {
				System.out.println(weight[l]);
			}
		}

		private static boolean sign(float a) {
			if(a>=0)
				return true;
			else
				return false;
		}

		private static float[] tweek(float[] weight, float output, float[] x1) {
			float[] newWeight= {0,0};
			for(int k=0;k<weight.length;k++) {
				newWeight[k] = weight[k]+(output*x1[k]);	
			}
			return newWeight;
	  }
}
