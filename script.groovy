// Directory of the cloned repository
def repoDir = 'Youtube-clone'

// Define the Nginx configuration
def nginxConfig = """
server {
    listen 8000;
    server_name localhost;

    location / {
        root ${repoDir};
        index youtube.html;
    }
}
"""

// Write the configuration to the Nginx sites-available directory
new File('/etc/nginx/sites-available/Youtube-clone').text = nginxConfig

// Create a symbolic link to enable the site
def symlinkCommand = 'ln -sf /etc/nginx/sites-available/Youtube-clone /etc/nginx/sites-enabled/Youtube-clone'
def symlinkProcess = symlinkCommand.execute()
symlinkProcess.waitFor()

// Test the Nginx configuration
def testCommand = 'nginx -t'
def testProcess = testCommand.execute()
testProcess.waitFor()

// Reload Nginx to apply the new configuration
def reloadCommand = 'systemctl reload nginx'
def reloadProcess = reloadCommand.execute()
reloadProcess.waitFor()
