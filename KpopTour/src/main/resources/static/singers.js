// Function to fetch the data from the server
async function fetchDataFromDB() {
  try {
    const response = await fetch('http://localhost:8088'); // Replace with your API endpoint, h2???
    if (!response.ok) {
      throw new Error('Network response was not ok.');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error('Error fetching data:', error);
    return [];
  }
}

// Function to create the div groups with the retrieved data
async function createDivGroupsFromDB() {
  const data = await fetchDataFromDB();
  const parentDiv = document.getElementById('dynamic-group');

  data.forEach((item) => {
    const divGroup = document.createElement('div');
    divGroup.classList.add('group-19');

    const img = document.createElement('img');
    img.classList.add('image-1');
    img.src = item.imageUrl;
    img.alt = 'image';

    const innerDivGroup = document.createElement('div');
    innerDivGroup.classList.add('group');

    const overlapGroup = document.createElement('div');
    overlapGroup.classList.add('overlap-group');

    const rectangle = document.createElement('div');
    rectangle.classList.add('rectangle-7');

    const link = document.createElement('a');
    link.href = item.link;

    const textDiv = document.createElement('div');
    textDiv.classList.add('blackpink-jennie', 'valign-text-middle', 'inter-bold-white-15px-2');
    textDiv.textContent = item.text;

    link.appendChild(rectangle);
    link.appendChild(textDiv);
    overlapGroup.appendChild(rectangle);
    overlapGroup.appendChild(link);
    innerDivGroup.appendChild(overlapGroup);
    divGroup.appendChild(img);
    divGroup.appendChild(innerDivGroup);

    parentDiv.appendChild(divGroup);
  });
}

// Call the function to create div groups from the database data
createDivGroupsFromDB();
