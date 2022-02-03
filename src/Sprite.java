import java.awt.Image;
import java.awt.Rectangle;

public class Sprite {
    
    int PosX;
    int PosY;
    int imageWidth;
    int imageHeight;
    Image imagemArq;

protected void setX(int x) {

    this.PosX = x;
}

int getX() {

    return PosX;
}

protected void setY(int y) {

    this.PosY = y;
}

int getY() {

    return PosY;
}

int getImageWidth() {

    return imageWidth;
}

int getImageHeight() {

    return imageHeight;
}

Image getImage() {

    return imagemArq;
}

Rectangle getRect() {

    return new Rectangle(PosX, PosY,
            imagemArq.getWidth(null), imagemArq.getHeight(null));
}

void getImageDimensions() {

    imageWidth = imagemArq.getWidth(null);
    imageHeight = imagemArq.getHeight(null);
}
}