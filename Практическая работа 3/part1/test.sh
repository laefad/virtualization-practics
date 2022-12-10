# Dockerfile 1
docker build -f Dockerfile -t df1 .
docker run df1

# Dockerfile 2
docker build -f Dockerfile.2 -t df2 .
docker run -p 8000:8000 df2
