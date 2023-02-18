package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog


        Blog blog = blogRepository2.findById(blogId).get();


        Image image = new Image();
        image.setDescription(description);
        image.setDimensions(dimensions);
        List<Image> currentImage = blog.getImageList();
        currentImage.add(image);
        blog.setImageList(currentImage);

        blogRepository2.save(blog);

        return image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`

        Image image=imageRepository2.findById(id).get();

        String imagesize=image.getDimensions();
        String []imagearr=imagesize.split("X");
        int ima1=Integer.parseInt(imagearr[0]);
        int ima2=Integer.parseInt(imagearr[1]);

        String []screenarr=screenDimensions.split("X");

        int scr1=Integer.parseInt(screenarr[0]);
        int scr2=Integer.parseInt(screenarr[1]);


        int scrmul=scr1*scr2;
        int imamul=ima1*ima2;
        return scrmul/imamul;




    }
}
