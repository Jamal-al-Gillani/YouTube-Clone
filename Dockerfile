# Use the official Nginx image from the Docker Hub
FROM nginx:alpine

# Copy the Nginx configuration file
COPY nginx.conf /etc/nginx/nginx.conf

# Copy the web app files into the Nginx container
COPY . /usr/share/nginx/html

# Expose port 80 inside the container
EXPOSE 80


