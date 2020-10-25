async function asyncFetch(url, expression){
  const response = await fetch(url);
  const json = await response.json();
  expression(json);
}
