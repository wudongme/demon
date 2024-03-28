package com.demon.io.http;

/**
 *
 * @desc
 * @fileName KeyUtil.java
 * @date 2023/11/18 10:57
 * @author Dongmo.Wu
 */
public class KeyUtil {
	public static String getPriKey() {
		return "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";
	}

	public static String getPublicKey() {
		return "MIIBojANBgkqhkiG9w0BAQEFAAOCAY8AMIIBigKCAYEA0aJpfHZZ+flDcX2guk2o/A7R6NXv0NsTjSYOKsqDnzgxOthkHTNcfAlyp4YZF8gA6MyNekuEu35mvjKmBDiJ+PwNjSeJVjaUDP0AZEM8ScjlMWcU3SJkkjO+EHgP3rTSiT5rwwRgByUuTaTwccMFni0OoNnhwa9gSia52UQ/ZjX/O6KLpW6H+sFd0+2bAd7F/hYol0k1wID07lDaBldCJAPrmoZ2+wVpjeykRFzBMKF85y8NvsChufp/PO9Z2gzU1aM1PTWGHz75jme/05Ks9XkzwRZXK3QI7Ebaljs/dTFKJhKmlABK6P2W8d/MEAHq72pd4Ulobj01jbF6tzfPPPbO0FWsWAxHvkYlfcwJcqvu6CNDO8cll7u+E4Vtu9ljqtpPHoYodDf1huspWFv/r4iP+Z7Iyqy419wpVjBP08Rk81/UHvCabolRg19lVu8+2r5aPhR4Hfnm2KckBxMPmmLmP9tBnrowKM0LoiMoTkny6vTj5/hrmyd/b4m8lYbPAgMBAAE=";
	}
}
