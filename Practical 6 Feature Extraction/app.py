import cv2
import matplotlib.pyplot as plt

# Function to extract color features from a 2D color image
def extract_color_features(image_path):
    # Read the input image
    image = cv2.imread(image_path)
    
    # Convert the image from BGR to RGB (OpenCV loads images in BGR format)
    image_rgb = cv2.cvtColor(image, cv2.COLOR_BGR2RGB)
    
    # Split the image into its 3 color channels: Red, Green, and Blue
    red_channel = image_rgb[:, :, 0]
    green_channel = image_rgb[:, :, 1]
    blue_channel = image_rgb[:, :, 2]
    
    # Convert the image to HSV color space
    hsv_image = cv2.cvtColor(image, cv2.COLOR_BGR2HSV)
    hue_channel = hsv_image[:, :, 0]
    saturation_channel = hsv_image[:, :, 1]
    value_channel = hsv_image[:, :, 2]
    
    # Convert the image to LAB color space
    lab_image = cv2.cvtColor(image, cv2.COLOR_BGR2LAB)
    l_channel = lab_image[:, :, 0]
    a_channel = lab_image[:, :, 1]
    b_channel = lab_image[:, :, 2]
    
    # Calculate histograms for each channel
    red_hist = cv2.calcHist([red_channel], [0], None, [256], [0, 256])
    green_hist = cv2.calcHist([green_channel], [0], None, [256], [0, 256])
    blue_hist = cv2.calcHist([blue_channel], [0], None, [256], [0, 256])
    hue_hist = cv2.calcHist([hue_channel], [0], None, [256], [0, 256])
    saturation_hist = cv2.calcHist([saturation_channel], [0], None, [256], [0, 256])
    value_hist = cv2.calcHist([value_channel], [0], None, [256], [0, 256])
    l_hist = cv2.calcHist([l_channel], [0], None, [256], [0, 256])
    a_hist = cv2.calcHist([a_channel], [0], None, [256], [0, 256])
    b_hist = cv2.calcHist([b_channel], [0], None, [256], [0, 256])
    
    return red_hist, green_hist, blue_hist, hue_hist, saturation_hist, value_hist, l_hist, a_hist, b_hist

# Function to plot histograms for color features
def plot_color_histograms(red_hist, green_hist, blue_hist, hue_hist, saturation_hist, value_hist, l_hist, a_hist, b_hist):
    plt.figure(figsize=(12, 10))
    
    # Plot Red channel histogram
    plt.subplot(3, 3, 1)
    plt.plot(red_hist, color='red')
    plt.title('Red Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot Green channel histogram
    plt.subplot(3, 3, 2)
    plt.plot(green_hist, color='green')
    plt.title('Green Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot Blue channel histogram
    plt.subplot(3, 3, 3)
    plt.plot(blue_hist, color='blue')
    plt.title('Blue Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot Hue channel histogram
    plt.subplot(3, 3, 4)
    plt.plot(hue_hist, color='orange')
    plt.title('Hue Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot Saturation channel histogram
    plt.subplot(3, 3, 5)
    plt.plot(saturation_hist, color='purple')
    plt.title('Saturation Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot Value channel histogram
    plt.subplot(3, 3, 6)
    plt.plot(value_hist, color='pink')
    plt.title('Value Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot L channel histogram
    plt.subplot(3, 3, 7)
    plt.plot(l_hist, color='brown')
    plt.title('L Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot A channel histogram
    plt.subplot(3, 3, 8)
    plt.plot(a_hist, color='gray')
    plt.title('A Channel Histogram')
    plt.xlim([0, 256])
    
    # Plot B channel histogram
    plt.subplot(3, 3, 9)
    plt.plot(b_hist, color='olive')
    plt.title('B Channel Histogram')
    plt.xlim([0, 256])
    
    plt.tight_layout()
    plt.show()

# Main function
def main():
    # Path to the input image
    image_path = 'D:\Engineering\BE Last Year\Information Storage & Retreival\ISR\ISR\Practical6\Groot.jpg'  # Replace this with the actual path to your image file
    
    # Extract color features
    red_hist, green_hist, blue_hist, hue_hist, saturation_hist, value_hist, l_hist, a_hist, b_hist = extract_color_features(image_path)
    
    # Plot histograms
    plot_color_histograms(red_hist, green_hist, blue_hist, hue_hist, saturation_hist, value_hist, l_hist, a_hist, b_hist)

# Run the program
if __name__ == "__main__":
    main()