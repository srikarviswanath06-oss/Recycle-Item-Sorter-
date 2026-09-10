let numItems = 0;
let count = 0;

const plasticItems = [];
const glassItems = [];
const metalItems = [];
const paperItems = [];

// Step 1: Get number of items
document.getElementById("startBtn").addEventListener("click", () => {
  numItems = parseInt(document.getElementById("numItems").value);

  if (isNaN(numItems) || numItems <= 0) {
    alert("Please enter a valid number of items!");
    return;
  }

  document.getElementById("step1").style.display = "none";
  document.getElementById("step2").style.display = "block";
  document.getElementById("counter").innerText = `Item ${count + 1} of ${numItems}`;
});

// Step 2: Add item
document.getElementById("addItemBtn").addEventListener("click", () => {
  const itemName = document.getElementById("itemName").value.trim();
  const itemType = document.getElementById("itemType").value;

  if (!itemName || !itemType) {
    alert("Please enter both item name and type!");
    return;
  }

  switch (itemType) {
    case "plastic": plasticItems.push(itemName); break;
    case "glass": glassItems.push(itemName); break;
    case "metal": metalItems.push(itemName); break;
    case "paper": paperItems.push(itemName); break;
    default: alert("Unknown type, skipping..."); return;
  }

  count++;
  document.getElementById("itemName").value = "";
  document.getElementById("itemType").value = "";
  
  if (count < numItems) {
    document.getElementById("counter").innerText = `Item ${count + 1} of ${numItems}`;
  } else {
    showResults();
  }
});

// Step 3: Display results
function showResults() {
  document.getElementById("step2").style.display = "none";
  document.getElementById("results").style.display = "block";

  displayList("plasticList", plasticItems);
  displayList("glassList", glassItems);
  displayList("metalList", metalItems);
  displayList("paperList", paperItems);
}

function displayList(listId, items) {
  const ul = document.getElementById(listId);
  ul.innerHTML = "";
  if (items.length === 0) {
    ul.innerHTML = "<li><em>No items added</em></li>";
  } else {
    items.forEach(item => {
      const li = document.createElement("li");
      li.textContent = item;
      ul.appendChild(li);
    });
  }
}

// 🧾 Download Results
document.getElementById("downloadBtn").addEventListener("click", () => {
  let text = "Recycle Item Sorter Results\n\n";
  text += "Plastic Bin:\n" + (plasticItems.join(", ") || "None") + "\n\n";
  text += "Glass Bin:\n" + (glassItems.join(", ") || "None") + "\n\n";
  text += "Metal Bin:\n" + (metalItems.join(", ") || "None") + "\n\n";
  text += "Paper Bin:\n" + (paperItems.join(", ") || "None") + "\n\n";

  const blob = new Blob([text], { type: "text/plain" });
  const link = document.createElement("a");
  link.href = URL.createObjectURL(blob);
  link.download = "Recycle_Item_Sorter_Results.txt";
  link.click();
});

// 🔄 Restart Functionality
document.getElementById("restartBtn").addEventListener("click", () => {
  location.reload();
});
