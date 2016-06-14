package com.main;

import javax.imageio.ImageIO;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by mlhamel on 3/1/16.
 */
public class TransformImage {

    private String name;
    private BufferedImage bufferedImage;
    byte[] imgIn;

    public enum Filter {
        CROP,
        REPLICATE,
        MIRROR
    }

    public TransformImage(String fileName) {
        this.name = fileName;
        load();
    }

    public void changeIntensity(String out, int nbLevels) {
        byte[] imgOut = decrease(nbLevels);
        saveImage(imgOut, out);
    }

    public void spatialMeanFilter(String out, int nbNeighbors, Filter type){
        byte[] imgOut = spatialFiltering(nbNeighbors, type);
        saveImage(imgOut, out);
    }

    private byte[] getByteImage(){
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
        return data.getData();
    }

    private void load(){
        try {
            File file = new File(name);
            bufferedImage = ImageIO.read(file);
            imgIn = getByteImage();
        } catch (IOException e) {
            System.out.println("Error reading image :" + name);
            System.out.println(e.getMessage());
        }
    }

    /**
     * Manage decrease intensity
     * @param intensity
     * @return byte[] image array
     */
    private byte[] decrease(int intensity){

        if (imgIn == null) throw new NullPointerException("Image null");

        int div = 256 / intensity;
        byte[] outImg = new byte[imgIn.length];

        for(int x = 0; x < imgIn.length; x++) {
            int res = (int)imgIn[x] / div;
            res = res * div;
            outImg[x] = (byte) res;
        }

        return outImg;
    }

    private byte[] spatialFiltering(int nb, Filter type) {
        if (imgIn == null) throw new NullPointerException("Image null");
        byte[] outImg = new byte[imgIn.length];

        float []kF = new float[nb*nb];
        Arrays.fill(kF, 1/(nb*nb));

        Kernel k = new Kernel(nb,nb, kF);
        ConvolveOp op = new ConvolveOp(k,  ConvolveOp.EDGE_NO_OP, null);
        BufferedImage outSrc = op.filter(bufferedImage, null);

        return outImg;
    }

    private int manageKernelSize(int nb){
        return 0;
    }

    private void saveImage(byte[] img, String outName){

        try {
            File outputFile = new File(outName);
            BufferedImage imgBuf = byte2Buffered(img,
                                                bufferedImage.getWidth(),
                                                bufferedImage.getHeight(),
                                                bufferedImage.getType());

            ImageIO.write(imgBuf, getFormat(name), outputFile);
        } catch (IOException e) {
            System.out.println("Error saving " + outName);
        }
    }

    private static BufferedImage byte2Buffered(byte[] imgIn, int width, int height, int type ){
        BufferedImage image = new BufferedImage(width, height, type);
        byte[] imgData = ((DataBufferByte)image.getRaster().getDataBuffer()).getData();
        System.arraycopy(imgIn, 0, imgData, 0, imgIn.length);
        return image;
    }

    public String getFormat(String imageName)
    {
        String imgStr = imageName.toLowerCase();

        if (imgStr.endsWith(".png")) return "PNG";
        if (imgStr.endsWith(".gif")) return "GIF";
        if (imgStr.endsWith(".tiff")) return "TIFF";
        if (imgStr.endsWith(".jpg")) return "JPG";
        if (imgStr.endsWith(".jpeg")) return "JPEG";


        return "UNKNOWN";
    }

    public static void main(String[] args) {
        if (args.length < 1){
            System.out.println("Missing filename / intensity levels / out name");
            return;
        }

        String fileName = args[0];
        String returnName = "out_" + fileName;


        TransformImage di = new TransformImage(fileName);
        for (int i = 128; i > 0; i/=2) {
            di.changeIntensity(i + "_" + returnName, i);
        }
        di.spatialMeanFilter( "CROP3_"+returnName, 3, Filter.CROP);
        di.spatialMeanFilter( "CROP10_"+returnName, 10, Filter.CROP);
        di.spatialMeanFilter( "CROP20_"+returnName, 20, Filter.CROP);
        di.spatialMeanFilter( "REP3_"+returnName, 3, Filter.REPLICATE);
        di.spatialMeanFilter( "REP10_"+returnName, 10, Filter.REPLICATE);
        di.spatialMeanFilter( "REP20_"+returnName, 20, Filter.REPLICATE);
        di.spatialMeanFilter( "MIR3_"+returnName, 3, Filter.MIRROR);
        di.spatialMeanFilter( "MIR10_"+returnName, 10, Filter.MIRROR);
        di.spatialMeanFilter( "MIR20_"+returnName, 20, Filter.MIRROR);
    }


}
