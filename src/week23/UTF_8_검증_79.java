package week23;

public class UTF_8_검증_79 {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int numBytes = getNumBytes(data[i]);

            if (numBytes == 0) {
                return false;
            }

            for (int j = 1; j < numBytes; j++) {
                if (i + j >= data.length || !isContinuationByte(data[i + j])) {
                    return false;
                }
            }

            i += numBytes;
        }

        return true;
    }

    private int getNumBytes(int num) {
        if ((num & 0x80) == 0) {
            return 1;
        } else if ((num & 0xE0) == 0xC0) {
            return 2;
        } else if ((num & 0xF0) == 0xE0) {
            return 3;
        } else if ((num & 0xF8) == 0xF0) {
            return 4;
        } else {
            return 0;
        }
    }

    private boolean isContinuationByte(int num) {
        return (num & 0xC0) == 0x80;
    }
}
