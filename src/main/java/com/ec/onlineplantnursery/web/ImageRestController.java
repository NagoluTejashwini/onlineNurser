package com.ec.onlineplantnursery.web;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;


import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ec.onlineplantnursery.entity.Image;
import com.ec.onlineplantnursery.repository.ImageRepository;
import com.ec.onlineplantnursery.repository.ProductRepo;
import com.ec.onlineplantnursery.service.ISeedServiceImpl;


import io.swagger.annotations.Api;

@RestController
@RequestMapping("/onlinenursery/image")
@Api(value = "Online Nursery Application")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ImageRestController {

	Logger log = LoggerFactory.getLogger(SeedRestController.class);
	@Autowired ProductRepo proRepo;
	
	@Autowired ImageRepository imageRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	//add image for corresponding item
	@PostMapping("/{pId}/addImages")
	public Optional<Object> addImage(@PathVariable(value = "pId") int pId, @RequestParam("proImage") MultipartFile file) throws IOException
		{
		System.out.println("addimage---");
			Image img = new Image(file.getOriginalFilename(), file.getContentType(), compressBytes(file.getBytes()));
			return proRepo.findById(pId).map(product ->{
				img.setProduct(product);
				return imageRepo.save(img);
			});
		}
		
		//get corresponding image for item id
	@GetMapping("/{pId}/productImage")
	public Image getImageByItemId(@PathVariable(value = "pId") int pId){
		
			final Optional<Image> retrievedImage = imageRepo.findByProduct_pId(pId);
			Image img = new Image(retrievedImage.get().getImageName(), 
					retrievedImage.get().getImageType(),
					decompressByte(retrievedImage.get().getPicByte()));
			img.setImageId(retrievedImage.get().getImageId());
			return img;
		}
	
	//get all images
	@GetMapping("/images")
	public List<Image> getAllImages(){
			List<Image> images = imageRepo.findAll();
			
			for (Image image: images)
			{
				Image newImage = image;
				image.setPicByte(decompressByte(newImage.getPicByte()));
			}
			
			return images;
		}

	private byte[] decompressByte(byte[] data) {
		// TODO Auto-generated method stub
		
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
		
	}

	private byte[] compressBytes(byte[] data) {
		// TODO Auto-generated method stub
		
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

	
	
	
}
